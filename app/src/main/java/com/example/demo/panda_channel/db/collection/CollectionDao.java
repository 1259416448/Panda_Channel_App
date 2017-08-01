package com.example.demo.panda_channel.db.collection;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by 闫雨婷 on 2017/8/1.
 */

public class CollectionDao {
    public static void main(String [] arg){

        Schema schema = new Schema(1,"com.example.demo.panda_channel.db.collection");
        Entity entity= schema.addEntity("MyCollection");
        entity.addIdProperty();

        entity.addStringProperty("img");
        entity.addStringProperty("title");
        entity.addStringProperty("date");
        entity.addStringProperty("moviepath");
        entity.addBooleanProperty("checkbox");
        entity.addBooleanProperty("flag");

        try {
            new DaoGenerator().generateAll(schema,"E:\\AndroidStudioWorkSpace\\Panda_Channel\\app\\src\\main\\java");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
