package com.github.DiamondPRO02.jarmu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.Assert.fail;

public class DomperTest {
    private static final int KAPACITAS = 100;
    private static final int SEBESSEG = 90;

    private Domper underTest;

    @Before
    public void setUp(){
        underTest = new Domper(KAPACITAS, SEBESSEG);
    }

    @After
    public void tearDown(){
        assertThat(underTest.getRakomany()).isEqualTo(0);
    }

    @Test
    public void motorBeindit_shouldSetJarAMotorTrue(){
        //given

        //when
        underTest.motorBeindit();
        //then
        if(!underTest.isJarAMotor()){
            throw new AssertionError("A JarAMotor nem lehet false");
        }
    }

    @Test
    public void motorLeallit_shouldSetJarAMotorFalse(){
        //given
        underTest.motorBeindit();
        //when
        underTest.motorLeallit();
        //then
        assertThat(underTest.isJarAMotor()).isFalse();
    }

    @Test(expected = IllegalStateException.class)
    public void platoKinyit_shouldThrowException_whenSebességIsNotZero(){
        //Given
        underTest.setSebesseg(1);
        //When
        underTest.platoKinyit();
    }

    @Test(expected = IllegalStateException.class)
    public void platoBecsuk_shouldThrowException_whenSebességIsNotZero(){
        //Given
        underTest.setSebesseg(1);
        //When
        underTest.platoBecsuk();
    }

    @Test
    public void elindul_shouldThrowException_whenSebessegIsNotZero() throws NemJarAMotorException{
        underTest.setSebesseg(1);
        try {
            underTest.elindul(32);
        } catch (IllegalStateException e){
            assertThat(underTest.getSebesseg()).isEqualTo(1);
            return;
        }

        fail("Expected IllegalStateException was not thrown");
    }

    @Test
    public void elindul_shouldThrownException_whenNemJarAMotor(){
        Throwable ex = catchThrowable(() -> underTest.elindul(32));
        assertThat(ex).isInstanceOf(NemJarAMotorException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void megall_shouldThrownException(){
        Throwable ex = catchThrowable(() -> underTest.elindul(32));
        assertThat(ex).isInstanceOf(NemJarAMotorException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }
}
//Given

//When

//Then