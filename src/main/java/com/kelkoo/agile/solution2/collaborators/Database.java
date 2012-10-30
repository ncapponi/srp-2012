package com.kelkoo.agile.solution2.collaborators;

public interface Database {

    void startTransaction();

    void doUpdate(String sqlUpdateRequest);

    void commit();

}
