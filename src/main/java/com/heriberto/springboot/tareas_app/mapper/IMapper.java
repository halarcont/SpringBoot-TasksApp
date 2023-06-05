package com.heriberto.springboot.tareas_app.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
