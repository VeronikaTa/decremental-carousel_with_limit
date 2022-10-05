package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    private int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }
    public CarouselRun run(){
        if(!runCreated){
            runCreated = true;
            if(carousel.size() == 0){
                for(int i = 0; i < maximumCapacity; i++){
                    carousel.add(0);
                }
            }
            return new CarouselRun(carousel, String.valueOf(getClass()), actionLimit);
        }
        else{
            return null;
        }
    }
}
