package com.phanative.module.security.service.analyze;

public class AnalyzeType implements Comparable<AnalyzeType>{

    private Long value;
    private Long value2;
    private Long value3;
    private Long value4;
    private Long value5;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer name;

    public AnalyzeType(Long value, Integer year, Integer month, Integer day) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.value = value;
        this.name = day;
    }

    public AnalyzeType(Long value, Integer year, Integer month) {
        this.value = value;
        this.year = year;
        this.month = month;
        this.name = month;
    }

    public AnalyzeType(Long value, Integer year) {
        this.year = year;
        this.value = value;
        this.name = year;
    }

    public AnalyzeType(Long value) {
        this.value = value;
    }

    public Integer getDay() {
        return day;
    }

    public Long getValue() {
        return value;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getName() {
        return name;
    }

    public Integer getMonth() {
        return month;
    }

    public Long getValue2() {
        return value2;
    }

    public Long getValue3() {
        return value3;
    }

    public Long getValue4() {
        return value4;
    }

    public Long getValue5() {
        return value5;
    }

    @Override
    public int compareTo(AnalyzeType o) {
        return o.getName().compareTo(this.getName());
    }
}
