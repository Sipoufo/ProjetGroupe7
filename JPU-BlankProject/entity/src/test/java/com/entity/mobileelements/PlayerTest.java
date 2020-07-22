package com.entity.mobileelements;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.EntityTest;
import entity.Map;
import entity.Sprite;

/**
 * The CollisionsHandler Class.
 *
 * @author Groupe 7 : Sipoufo, Regina, Christ, Wilfrid
 * @version 1.0
 */

public class PlayerTest extends EntityTest {

	/** The player of the test */
	private static Player pTest;
	/** The key pressed by the player */
    private static char keyPressed;
    /** The map of the player */
    private Map map;
    /** The basic sprite of the player */
    private static final Sprite spriteDown = new Sprite('y', "Rockford.png");
    /** The left sprite of the player */
    private static final Sprite spriteTurnLeft = new Sprite('y', "Left_Rockford.png");
    /** The right sprite of the player */
    private static final Sprite spriteTurnRight = new Sprite('y', "Right_Rockford.png");
    /** The up sprite of the player */
    private static final Sprite spriteUp = new Sprite('y', "Back_Rockford1.png");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entity = new Player(6,6);
		pTest  = new Player(0,0);
		keyPressed = 'Z';
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map(425,"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" +
                "qttttttuoutttttttttttttttttttttttttttttq\r\n" +
                "qtttttttoqtttttoootttttttttuuttttqqttttq\r\n" +
                "qtttttttxqtoottttttqtttttttttttttttqtttq\r\n" +
                "qttttttttqttttttttqttttttttttttttttttttq\r\n" +
                "qtttuttttttttttttqttttttttqttttutttttttq\r\n" +
                "qtttuttttqttttttttttttttttxtttttttttqqtq\r\n" +
                "qttttttttqtttutttttttttuottttttttttttttq\r\n" +
                "qttttttttxtttutttttttttuqqqqqqtttttttttq\r\n" +
                "qttttttttqttttttttotttttttttttttttootttq\r\n" +
                "qttttxtttttttttttttottttttttttttttxotttq\r\n" +
                "qtttqqtttutttttqtttootttttttqttttttttttq\r\n" +
                "qttttqtttttttttttttttotttqttqttttttttttq\r\n" +
                "qtttttttttttttttttttttttttttqttttttttttq\r\n" +
                "qttttttttttqqtttttttoutttttttttttttttttq\r\n" +
                "qtootttttttttttttttqqittttutttttttqttttq\r\n" +
                "qttttqttttttttttttttquttttuttttttttttttq\r\n" +
                "qtttttqttttttttttttttttttttttttttttttttq\r\n" +
                "qttotttttttuutttttqtttttttqttttttttotttq\r\n" +
                "qttutttttttttttttqtqtttttttttttttttotttq\r\n" +
                "qtttttttttttttttxxxttxttttttqqtttttxtttq\r\n" +
                "qtttttttttttttttuuutttttttttqttttttttttq\r\n" +
                "qtttttttqqqtttttuiuttttoottttttuuttttttq\r\n" +
                "qtttttttttttttttttttttttottttttttttttttq\r\n" +
                "qtttttttxxtqqqtttttttqqqxttttttttotttttq\r\n" +
                "qtttqotttttttttttttttqtttttttttttttttttq\r\n" +
                "qtttqtttttttttttttutttttttuttttttqtttttq\r\n" +
                "qttttttuttttttqtttttottttttttttttqtttttq\r\n" +
                "qttuttttttttttttttttotttttttttttqttttttq\r\n" +
                "qttttttttqxttttttttototttttttttttttttttq\r\n" +
                "qtttttttttqttttuttttottqqttttuiutttttttq\r\n" +
                "qttttutttttqtttttttttttqottttttttttttttq\r\n" +
                "qtttttttttttqtttttttttqqxttttttttqqttttq\r\n" +
                "qottqtttttttttttutttttttttttutttttqttttq\r\n" +
                "qottqxtttttttttuttttttttttttutttttqttttq\r\n" +
                "qottqttttttuotttttoqqqtttttutttttttttttq\r\n" +
                "qottqqqqttttttttttutttttttttttttttxttttq\r\n" +
                "qxttttttttttttttttyetttttttttttttttttttq\r\n" +
                "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", 7);
     this.map.createMapToChars();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayer() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Rockford.png";
		final char expectedCharName = 'y';
		assertEquals(expectedCharName, entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, entity.getSprite().getImageName());
		assertNull(entity.getStrategy());
	}

	@Test
	public void testMovePlayer() {
		switch (keyPressed) {
        case 'Z':
            pTest.setSprite(spriteDown);
            break;
        case 'Q':
            pTest.setSprite(spriteTurnLeft);
            break;
        case 'S':
            pTest.setSprite(spriteUp);
            break;
        case 'D':
            pTest.setSprite(spriteTurnRight);
            break;
        }
        assertEquals(spriteDown, pTest.getSprite());
	}
	
	@Test
	public void testPlayerIsAlive() {
		
		final boolean expectedAliveBeforeStone = true;
		assertEquals(expectedAliveBeforeStone, map.getPlayer().isAlive);

		final boolean expectedAliveAfterStone = false;
	      for (int i=0;i<2;i++) {
	          map.runStrategies();
	      }
	     assertEquals(expectedAliveAfterStone, map.getPlayer().isAlive);
	}
	
	@Test
	public void testDiamondCounterPlayer() {	
		final int expectedInitialDiamondCounter = 0;
		
		assertEquals(expectedInitialDiamondCounter, pTest.getDiamondsCounter());
		
		pTest.incrementDiamondsCounter();
		
		final int expectedIncrementedDiamondCounter = 1;
		
		assertEquals(expectedIncrementedDiamondCounter, pTest.getDiamondsCounter());
		
		pTest.increaseDiamondsCounter(4);
		
		final int expectedIncreasedDiamondCounter = 5;
		
		assertEquals(expectedIncreasedDiamondCounter, pTest.getDiamondsCounter());
	}
	
	@Test
	public void testDidPlayerWin() {
		
		final boolean expectedWin = true;
	     map.getPlayer().increaseDiamondsCounter(9);
	     map.getPlayer().didPlayerWin(7);
	 
	    assertEquals(expectedWin, map.getPlayer().getIsWin());
	}
}
