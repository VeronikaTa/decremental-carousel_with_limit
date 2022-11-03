package com.epam.training.student_veronika_tarasova.decrementing_carousel_with_limit.src.test.java.com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecrementingCarouselTest {

    @Test
    void checkAddElement() {
        com.epam.rd.autotasks.DecrementingCarousel carousel = new com.epam.rd.autotasks.DecrementingCarousel(5);
        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-1));
        assertFalse(carousel.addElement(-123456));
        assertFalse(carousel.addElement(0));

        assertTrue(carousel.addElement(1));
        assertTrue(carousel.addElement(2));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-123));

        assertTrue(carousel.addElement(1234));
        assertTrue(carousel.addElement(1234));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-456));

        assertTrue(carousel.addElement(22));

        assertFalse(carousel.addElement(22));

        assertFalse(carousel.addElement(-856));
        assertFalse(carousel.addElement(0));

        assertFalse(carousel.addElement(357));
        assertFalse(carousel.addElement(159));
        assertFalse(carousel.addElement(1));
    }

    @Test
    void checkAddElementAfterRun() {
        com.epam.rd.autotasks.DecrementingCarousel carousel = new com.epam.rd.autotasks.DecrementingCarousel(5);

        assertTrue(carousel.addElement(1));
        assertTrue(carousel.addElement(2));
        assertTrue(carousel.addElement(3));

        carousel.run();

        assertFalse(carousel.addElement(4));
        assertFalse(carousel.addElement(5));
        assertFalse(carousel.addElement(6));

        assertFalse(carousel.addElement(0));
        assertFalse(carousel.addElement(-123));
        assertFalse(carousel.addElement(-4568));
    }

    @Test
    void testCarouselRunsSingleTimeOnly() {
        com.epam.rd.autotasks.DecrementingCarousel carousel = new com.epam.rd.autotasks.DecrementingCarousel(4);
        carousel.addElement(4);

        assertNotNull(carousel.run());
        assertNull(carousel.run());
        assertNull(carousel.run());
    }


}