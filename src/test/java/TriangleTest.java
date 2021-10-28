import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static WebUI.Triangle.TriangleSquare;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("Логирование");
    }

    @Test
    public void positiveTriangleTest() throws Exception {
        double square = TriangleSquare(3, 4, 5);
        Assertions.assertEquals(6, square);
    };

    @Test
    public void negativeTriangleTest() throws Exception {
        double square = TriangleSquare(-3, 4, -5);
        Assertions.assertThrows(Exception.class, () -> TriangleSquare(-3, 4, -5));
    }
}
