package com.kelkoo.agile.solution1;

public interface Database {

    void startTransaction();

    void doUpdate(String sqlUpdateRequest);

    void commit();

}
