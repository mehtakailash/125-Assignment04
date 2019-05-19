package com.scg.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonalNameTest {
	
	private static final String     LAST   = "Mehta";
    private static final String     FIRST  = "Kail";
    private static final String     MIDDLE = "BR";

    
	PersonalName personalName = new PersonalName(LAST,FIRST,MIDDLE);

	@Test 
	void testConstructorlValues() {
		PersonalName personalName = new PersonalName();
		assertTrue( personalName.getLastName().isEmpty() );
        assertTrue( personalName.getFirstName().isEmpty() );
        assertTrue( personalName.getMiddleName().isEmpty() );
        
        personalName = new PersonalName( null, null );
        assertTrue( personalName.getLastName().isEmpty() );
        assertTrue( personalName.getFirstName().isEmpty() );
        assertTrue( personalName.getMiddleName().isEmpty() );
		
		personalName = new PersonalName(LAST,FIRST,MIDDLE);
		assertEquals( LAST, personalName.getLastName() );
        assertEquals( FIRST, personalName.getFirstName() );
        assertEquals( MIDDLE, personalName.getMiddleName() );
		
		
	}	
	
	@Test
	void testToString() {
		PersonalName personalName = new PersonalName();
		assertNotNull(personalName.toString());
//		assertTrue((personalName.getFirstName().equals("(no first name)")));
//		assertTrue((personalName.getLastName().equals("(no last name)")));
	}
	
	PersonalName personalName3 = new PersonalName(LAST,FIRST);
//	PersonalName personalName = new PersonalName();
	PersonalName personalName4 = new PersonalName("(no last name)","(no first name)");

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testEquals() {
		String     STREET     = "123 test";
		String     CITY       = "Bellevue";
	    StateCode  STATE      = StateCode.WA;
	    String     ZIP        = "98207";
	    Address address = new Address(STREET,CITY,STATE,ZIP);
	    
		assertEquals("(no first name)",personalName4.getFirstName());
		assertFalse(personalName.equals(personalName4));
		assertFalse(personalName.equals(personalName3));
		assertTrue(personalName.getFirstName().equals(personalName3.getFirstName()));
		assertFalse(personalName.equals(null));
		assertFalse(personalName.equals(address));
	}
	
	@Test
	void testHashCode() {
		assertNotNull(personalName.hashCode());
	}
	
	@Test
	void testCompare() {
		assertNotNull(personalName.compare(personalName, personalName4));
		assertThrows(NullPointerException.class, ()-> personalName.compare(null, null ));
		assertThrows(NullPointerException.class, ()-> personalName.compare(null, personalName4 ));
		assertThrows(NullPointerException.class, ()-> personalName.compare(personalName, null ));
	}
	
}
