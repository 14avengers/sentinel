package sentinelgroup.io.sentinel.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.NonNull;
import sentinelgroup.io.sentinel.util.AppExecutors;

public class ReceiveViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final AppExecutors mAppExecutors;

    public ReceiveViewModelFactory(AppExecutors iAppExecutors) {
        mAppExecutors = iAppExecutors;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new ReceiveViewModel(mAppExecutors);
    }
}
