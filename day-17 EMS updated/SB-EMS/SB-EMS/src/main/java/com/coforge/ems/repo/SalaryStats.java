package com.coforge.ems.repo;

/**
 * Projection interface for salary statistics aggregation.
 */
public interface SalaryStats {

    Long getCount();

    Double getSum();

    Double getMax();

    Double getMin();
}
