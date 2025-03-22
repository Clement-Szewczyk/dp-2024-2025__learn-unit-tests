package fr.anthonyquere.teashop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeaShopTest {

    private TeaShop teaShop;
    private Tea greenTea;
    private Tea blackTea;

    @BeforeEach
    void setUp() {
        teaShop = new TeaShop(80);
        greenTea = new Tea("Green Tea", 120, 75, true);
        blackTea = new Tea("Black Tea", 180, 90, false);
        teaShop.addTea(greenTea);
    }

    @Test
    void shouldAddTeaToShop() {
        teaShop.addTea(blackTea);
        TeaCup cup = teaShop.prepareTea("Black Tea");
        assertThat(cup).isNotNull();
    }

    @Test
    void shouldPrepareExistingTea() {
        TeaCup cup = teaShop.prepareTea("Green Tea");
        assertThat(cup).isNotNull();
    }

    @Test
    void shouldThrowExceptionForNonExistingTea() {
        assertThatThrownBy(() -> teaShop.prepareTea("Earl Grey"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Tea not available");
    }

    @Test
    void shouldSetDefaultWaterTemperature() {
        TeaShop newShop = new TeaShop(85);
        newShop.addTea(greenTea);
        // Indirect testing via prepareTea method
        TeaCup cup = newShop.prepareTea("Green Tea");
        assertThat(cup).isNotNull();
    }

    @Test
    void shouldChangeWaterTemperature() {
        teaShop.setWaterTemperature(95);
        // Indirect testing, could be enhanced with a getter
        TeaCup cup = teaShop.prepareTea("Green Tea");
        assertThat(cup).isNotNull();
    }

    @Test
    void shouldThrowExceptionForInvalidTemperature() {
        assertThatThrownBy(() -> teaShop.setWaterTemperature(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("temperature must be between 0 and 100");

        assertThatThrownBy(() -> teaShop.setWaterTemperature(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("temperature must be between 0 and 100");
    }

    @Test
    void shouldIgnoreCaseForTeaNames() {
        TeaCup cup = teaShop.prepareTea("green tea");
        assertThat(cup).isNotNull();
    }
}