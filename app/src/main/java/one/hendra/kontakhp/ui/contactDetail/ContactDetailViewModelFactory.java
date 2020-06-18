package one.hendra.kontakhp.ui.contactDetail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ContactDetailViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {

    private int mContactId;
    private Application mApplication;

    public ContactDetailViewModelFactory(@NonNull Application application, int contactId) {
        super(application);
        mApplication = application;
        mContactId = contactId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ContactDetailViewModel(mApplication, mContactId);
    }
}
