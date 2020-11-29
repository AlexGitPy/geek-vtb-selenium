package lesson4.homework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    private final AreaOfATriangle areaOfATriangle = new AreaOfATriangle();

    @BeforeAll
    static void setLogger() {
        logger.debug("@BeforeAll - Execute once before all ...");
    }

    @Test
    public void triangleTest() {
        double area = areaOfATriangle.areaOfATriangle(2,3,2);
        System.out.println(area);
        assertThat(1.984313483298443).isEqualTo(area);
    }

    @Test
    public void doubleTest() {
        double area = areaOfATriangle.areaOfATriangle(2,3,2);
        assertEquals(1.984313483298443, area);
        assertEquals(1.984, area, 0.001);

    }

}
