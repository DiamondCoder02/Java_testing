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
        assertThat(underTest.isJarAMotor()).isTrue();
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

    @Test
    public void platoBecsuk_shouldThrowException_whenSebességIsNotZero(){
        //Given
        underTest.setPlatoNyitva(true);
        //When
        underTest.platoBecsuk();
        //Then
        assertThat(underTest.isPlatoNyitva()).isFalse();
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

    @Test
    public void elindul_platoIsNyitva(){
        underTest.setPlatoNyitva(true);
        underTest.setJarAMotor(true);

        Throwable ex = catchThrowable(() -> underTest.elindul(10));

        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void elindul_tooFast(){
        underTest.setJarAMotor(true);

        Throwable ex = catchThrowable(() -> underTest.elindul(SEBESSEG + 1));

        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void elindul() throws NemJarAMotorException{
        underTest.setJarAMotor(true);

        underTest.elindul(SEBESSEG);

        assertThat(underTest.getSebesseg()).isEqualTo(SEBESSEG);
    }

    @Test
    public void  gyorsit_nemJarAMotor(){

    }

    @Test
    public void  gyorsit_platoNyitva(){
        underTest.setJarAMotor(true);
        underTest.setPlatoNyitva(true);

        Throwable ex = catchThrowable(() -> underTest.gyorsit(10));

        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void  gyorsit_tooFast(){
        underTest.setJarAMotor(true);

        Throwable ex = catchThrowable(() -> underTest.gyorsit(SEBESSEG + 1));

        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void  gyorsit() throws NemJarAMotorException{
        underTest.setJarAMotor(true);
        underTest.setSebesseg(30);

        underTest.gyorsit(10);

        assertThat(underTest.getSebesseg()).isEqualTo(40);
    }

    @Test
    public void  megall(){
        underTest.setSebesseg(SEBESSEG);

        underTest.megall();

        assertThat(underTest.getSebesseg()).isEqualTo(0);
    }

    @Test
    public void felrakod_tulNagyARakomany(){
        Throwable ex = catchThrowable(()-> underTest.felrakod(KAPACITAS + 1));

        assertThat(ex).isInstanceOf(IllegalStateException.class);
        assertThat(underTest.getRakomany()).isEqualTo(0);
    }
    @Test
    public void felrakod(){
        underTest.setRakomany(10);

        underTest.felrakod(20);

        assertThat(underTest.getRakomany()).isEqualTo(30);
    }
    @Test
    public void lerakod_platoCsukva(){
        underTest.setRakomany(10);

        Throwable ex = catchThrowable(()-> underTest.lerakod());

        assertThat(underTest.getRakomany()).isEqualTo(10);
    }
}
//Given

//When

//Then