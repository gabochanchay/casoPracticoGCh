package com.gabriel.chanchay;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.security.SecureRandom;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gabriel.chanchay.dao.ClienteDao;
import com.gabriel.chanchay.dao.servicio.ClienteServicio;
import com.gabriel.chanchay.modelo.Cliente;

@SpringBootTest
class ClienteTests {
	
	@Autowired
	ClienteServicio clienteServicio;
	
	@Autowired
	ClienteDao clienteDao;
	
    private final Random RANDOMICO = new SecureRandom();
    private final String LETRAS = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";

    private String generarRandomico(int numerocaracteres) {
        StringBuffer buffer = new StringBuffer(numerocaracteres);
        for (int i = 0; i < numerocaracteres; i++) {
            buffer.append(LETRAS.charAt(RANDOMICO.nextInt(LETRAS.length())));
        }
        return new String(buffer);
    } 

	@Test
	public void testCrearPersona() {
		Cliente c=new Cliente();
		c.setNombre("Juan" + generarRandomico(4));
		c.setDireccion("Quito");
		c.setContrasena("8765");
		c.setEdad(78);
		c.setTelefono("099545302");
		c.setEstado("A");
		try {
			c=clienteServicio.crear(c);
			assertNotNull(clienteDao.findById(c.getId()).get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
