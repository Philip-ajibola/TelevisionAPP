import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class TelevisionTest {
    private Television television;

    @BeforeEach
    public void initializingTelevision(){
        television = new Television();
    }

    @Test
    public void testThatIfIonTelevisionIsOn_TelevisionOn() {
        assertFalse(television.isTelevisionOn());
        television.toggleSwitch();
        assertTrue(television.isTelevisionOn());

    }

    @Test
    public void testThatIfIonTelevisionIsOff_TelevisionOff() {
        assertFalse(television.isTelevisionOn());
        television.toggleSwitch();
        assertTrue(television.isTelevisionOn());
        television.toggleSwitch();
        assertFalse(television.isTelevisionOn());

    }


    @Test
    public void testThatWhenIncreaseVolume_VolumeIncrease(){
        assertEquals(0,television.getVolume());
        television.toggleSwitch();
        for(int count=1; count<=5;count++){
            television.increaseVolume();
        }
        assertEquals(5,television.getVolume());

    }

    @Test
    public void testThatIfTelevisionIsOff_VolumeShouldNotIncrease() {
        assertEquals(0,television.getVolume());

        for(int count=1; count<=5;count++){
            television.increaseVolume();
        }
        assertEquals(0,television.getVolume());

    }

    @Test
    public void testThatIfTelevisionIsOff_VolumeShouldNotIDecrease() {
        assertEquals(0,television.getVolume());

        for(int count=1; count<=5;count++){
            television.increaseVolume();
        }
        assertEquals(0,television.getVolume());

    }

    @Test
    public void testThatWhenDecreaseVolume_VolumeDecrease(){
        assertEquals(0,television.getVolume());
        television.toggleSwitch();
        for(int count=1; count<=5;count++){
            television.increaseVolume();
        }
        for(int count = 1;count<=3;count++){
            television.decreaseVolume();
        }
        assertEquals(2,television.getVolume());

    }
    @Test
    public void testThatWhenVolumeIsZeroAndIDecrease_VolumeShouldBeZero(){
        assertEquals(0,television.getVolume());
        television.toggleSwitch();
        for(int count=1; count<=5;count++){
            television.increaseVolume();
        }
        for(int count = 1;count<=9;count++){
            television.decreaseVolume();
        }
        assertEquals(0,television.getVolume());

    }

    @Test
    public void testThatWhenVolumeIsTenAndIDecrease_VolumeShouldBeTen(){
        assertEquals(0,television.getVolume());
        television.toggleSwitch();
        for(int count=1; count<=15;count++){
            television.increaseVolume();
        }

        assertEquals(10,television.getVolume());

    }
    @Test
    public void test_thatWhenINextChannel_channelIncreaseBy1() {
        television.toggleSwitch();
        for(int count = 1;count<=14;count++){
            television.goToNextChannel();
        }
        assertEquals(15,television.getChannel());
    }

    @Test
    public void test_thatWhenINextChannelOver30_channelShouldStartFromOne() {
        television.toggleSwitch();
        for(int count = 1;count<45;count++){
            television.goToNextChannel();
        }
        assertEquals(15,television.getChannel());

    }

    @Test
    public void test_thatWhenPressPreviousChannel_channelDecreaseBy1() {
        television.toggleSwitch();
        for(int count = 1;count<=14;count++){
            television.goToNextChannel();
        }
        television.goToPreviousChannel();
        assertEquals(14,television.getChannel());
    }

    @Test
    public void test_thatWhenIPressPreviousChannelLessThan1_channelShouldgoToTHirty() {
        television.toggleSwitch();
        for(int count = 1;count<15;count++){
            television.goToNextChannel();
        }
        assertEquals(15,television.getChannel());

        for(int count = 1;count<21;count++){
            television.goToPreviousChannel();
        }
        assertEquals(25,television.getChannel());
    }
    @Test
    public void testThatWhenIInputChannelNumber_ChannelDisplay(){
        television.toggleSwitch();
        String result = television.goToChannelOfYourChoice(25);
        assertEquals("25",result);
    }

    @Test
    public void testThatWhenIInputInvalidChannelNumber_ChannelDisplayInValidChannelNumber(){
        television.toggleSwitch();
        String result = television.goToChannelOfYourChoice(35);
        assertEquals("channel 35 not found",result);
    }
}