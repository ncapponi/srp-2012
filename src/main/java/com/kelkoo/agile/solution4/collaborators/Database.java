package com.kelkoo.agile.solution4.collaborators;

public interface Database {

    void startTransaction();

    void doUpdate(String sqlUpdateRequest);

    void commit();

}
