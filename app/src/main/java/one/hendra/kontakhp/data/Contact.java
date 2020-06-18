package one.hendra.kontakhp.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    @ColumnInfo(name = "phone_number")
    public String phoneNumber;

}
