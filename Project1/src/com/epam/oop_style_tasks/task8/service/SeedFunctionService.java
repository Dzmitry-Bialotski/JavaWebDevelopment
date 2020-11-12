package com.epam.oop_style_tasks.task8.service;

import com.epam.oop_style_tasks.task8.entity.IFunctionable;

public class SeedFunctionService {
    public IFunctionable seedFunctionForTask8()
    {
        return (x) -> (x >= 3) ? ( - x * x + 3 * x + 9 ) : (1 / (Math.pow(x, 3) - 6));
    }
}
