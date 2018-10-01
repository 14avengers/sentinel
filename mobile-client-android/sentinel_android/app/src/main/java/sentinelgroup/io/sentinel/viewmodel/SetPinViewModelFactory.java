package sentinelgroup.io.sentinel.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.NonNull;
import sentinelgroup.io.sentinel.repository.PinRepository;

public class SetPinViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final PinRepository mRepository;

    public SetPinViewModelFactory(PinRepository iRepository) {
        mRepository = iRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new SetPinViewModel(mRepository);
    }
}
