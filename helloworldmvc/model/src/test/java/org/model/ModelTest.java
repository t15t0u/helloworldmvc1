package org.model;

import static org.junit.Assert.*;
import org.junit.*;

public class ModelTest {
	 private Model model;
	 @Before
	 public void setUp() throws Exception {
	 this.model = new Model();
	 }
	 @Test
	 public void testGetHelloWorld() {
	 assertEquals("Hello World", this.model.getHelloWorld());
	 }
	} 