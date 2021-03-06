package panda_channel.db.collection;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import panda_channel.db.collection.MyHistroy;

import panda_channel.db.collection.MyHistroyDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig myHistroyDaoConfig;

    private final MyHistroyDao myHistroyDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        myHistroyDaoConfig = daoConfigMap.get(MyHistroyDao.class).clone();
        myHistroyDaoConfig.initIdentityScope(type);

        myHistroyDao = new MyHistroyDao(myHistroyDaoConfig, this);

        registerDao(MyHistroy.class, myHistroyDao);
    }
    
    public void clear() {
        myHistroyDaoConfig.getIdentityScope().clear();
    }

    public MyHistroyDao getMyHistroyDao() {
        return myHistroyDao;
    }

}
