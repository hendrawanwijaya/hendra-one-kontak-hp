package one.hendra.kontakhp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class ContactDao {

    @Query("SELECT * FROM contact")
    public abstract LiveData<List<Contact>> getContacts();

    @Query("SELECT * FROM contact WHERE id=:contactId")
    public abstract LiveData<Contact> getContact(int contactId);

    @Insert
    public abstract void addContact(Contact contact);

    @Update
    public abstract void updateContact(Contact contact);

    @Delete
    public abstract void deleteContact(Contact contact);

}
