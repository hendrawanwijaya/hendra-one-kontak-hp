package one.hendra.kontakhp.ui.contactDetail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import one.hendra.kontakhp.data.AppDatabase;
import one.hendra.kontakhp.data.Contact;
import one.hendra.kontakhp.data.ContactDao;

public class ContactDetailViewModel extends AndroidViewModel {

    public LiveData<Contact> contact;
    private ContactDao mContactDao;

    public ContactDetailViewModel(@NonNull Application application, int contactId) {
        super(application);
        mContactDao = AppDatabase.getDatabase(application).contactDao();
        contact = mContactDao.getContact(contactId);
    }

    public void save(){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mContactDao.updateContact(contact.getValue());
            }
        });
    }

    public void delete(){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mContactDao.deleteContact(contact.getValue());
            }
        });
    }
}
