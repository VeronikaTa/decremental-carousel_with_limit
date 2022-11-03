package com.epam.training.student_veronika_tarasova.decrementing_carousel_with_limit.src.main.java.com.epam.rd.autotasks;

import java.util.LinkedList;

public class CarouselRun {
    LinkedList<Integer> carousel = new LinkedList<>();
    private  int index;
    private int turnsNumber;
    private int gradualDecrement;
    private String getClass;
    private int actionLimit = -1;

    CarouselRun(LinkedList<Integer> carousel, String getClass){
        for(Integer element : carousel){
            this.carousel.add(element);
        }
        this.getClass = getClass;
        this.gradualDecrement = 0;
        this.index = 0;
        this.turnsNumber = 0;
    }

    CarouselRun(LinkedList<Integer> carousel, String getClass, int actionLimit){
        for(Integer element : carousel){
            this.carousel.add(element);
        }
        this.getClass = getClass;
        this.gradualDecrement = 0;
        this.index = 0;
        this.turnsNumber = 0;
        this.actionLimit = actionLimit;
    }
    public int next() {
        if(isFinished()){
            return -1;
        }
        int current = 0;
        boolean nextElementFound = false;

        while(!nextElementFound){
            if(this.zeroIndex()){
                this.increaseGradualDecrement();
            }
            if(carousel.get(index) > 0){
                current = carousel.get(index);
                carousel.set(index, changeElement(current));
                changeIndex();
                nextElementFound = true;
            }
            else{
                changeIndex();
            }
        }
        this.actionLimit --;
        return current;
    }

    public boolean isFinished() {
        if(outOfRunLimit()){
        return true;
        }
        boolean finished = false;
        for(int value : carousel){
            if(value <= 0){
                finished = true;
            }
            else{
                finished = false;
                break;
            }
        }
        return finished;
    }

    public void changeIndex(){
        if(index != (carousel.size() - 1)){
            index ++;
        }
        else{
            index = 0;
        }
    }
    private int changeElement(int current){
        if(getClass.contains("GraduallyDecreasingCarousel")){
            return current - gradualDecrement;
        }
        else if (getClass.contains("HalvingCarousel")){
            return current / 2;
        }
        else if(this.getClass.contains("DecrementingCarousel") || getClass.contains("DecrementingCarouselWithLimitedRun")){
            return current - 1;
        }
        else{
            return 0;
        }
    }

    private boolean zeroIndex(){
        return index == 0;
    }
    private void increaseGradualDecrement(){
        gradualDecrement ++;
    }
    private  boolean outOfRunLimit(){
        return actionLimit == 0;
    }
}
