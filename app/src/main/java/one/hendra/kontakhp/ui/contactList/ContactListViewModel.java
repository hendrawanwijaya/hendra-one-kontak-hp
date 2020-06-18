package one.hendra.kontakhp.ui.contactList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import one.hendra.kontakhp.data.AppDatabase;
import one.hendra.kontakhp.data.Contact;
import one.hendra.kontakhp.data.ContactDao;

public class ContactListViewModel extends AndroidViewModel {

    public LiveData<List<Contact>> contacts;

    public ContactListViewModel(@NonNull Application application) {
        super(application);
        ContactDao contactDao = AppDatabase.getDatabase(application).contactDao();
        contacts = contactDao.getContacts();
    }
}
