/*
 * Copyright Lealone Database Group.
 * Licensed under the Server Side Public License, v 1.
 * Initial Developer: zhh
 */
package org.lealone.test.aote;

import org.junit.Test;
import org.lealone.transaction.Transaction;
import org.lealone.transaction.TransactionMap;

public class TransactionCommitTest extends AoteTestBase {
    @Test
    public void run() {
        String mapName = TransactionCommitTest.class.getSimpleName();
        Transaction t = te.beginTransaction(false);
        TransactionMap<String, String> map = t.openMap(mapName, storage);
        map.put("2", "b");
        map.put("3", "c");
        map.remove();
        t.commit();

        t = te.beginTransaction(false);
        map = t.openMap(mapName, storage);
        map.put("4", "b4");
        map.put("5", "c5");
        t.asyncCommit();
    }
}
