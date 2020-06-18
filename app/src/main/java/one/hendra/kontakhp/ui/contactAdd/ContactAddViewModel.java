package one.hendra.kontakhp.ui.contactAdd;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import one.hendra.kontakhp.data.AppDatabase;
import one.hendra.kontakhp.data.Contact;
import one.hendra.kontakhp.data.ContactDao;

public class ContactAddViewModel extends AndroidViewModel {

    public MutableLiveData<Contact> contact;
    private ContactDao mContactDao;

    public ContactAddViewModel(@NonNull Application application) {
        super(application);
        mContactDao = AppDatabase.getDatabase(application).contactDao();
        contact = new MutableLiveData<>();
        contact.setValue(new Contact());
    }

    public void add(){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mContactDao.addContact(contact.getValue());
            }
        });
    }
}
