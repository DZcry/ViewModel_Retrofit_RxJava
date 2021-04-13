package leavesc.hello.network.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import leavesc.hello.network.http.basis.callback.RequestMultiplyCallback;
import leavesc.hello.network.http.basis.exception.base.BaseException;
import leavesc.hello.network.http.datasource.FailExampleDataSource;
import leavesc.hello.network.http.datasource.TestExampleDataSource;
import leavesc.hello.network.http.repo.FailExampleRepo;
import leavesc.hello.network.http.repo.TestExampleRepo;
import leavesc.hello.network.model.Test;
import leavesc.hello.network.viewmodel.base.BaseViewModel;

/**
 * 作者：leavesC
 * 时间：2019/1/30 13:08
 * 描述：
 */
public class TestExampleViewModel extends BaseViewModel {

    private MutableLiveData<Test> test1LiveData = new MutableLiveData<>();

    private TestExampleRepo testExampleRepo = new TestExampleRepo(new TestExampleDataSource(this));

    public void test(String id) {
        testExampleRepo.test(id).observe(lifecycleOwner, new Observer<Test>() {
            @Override
            public void onChanged(@Nullable Test test) {
                test1LiveData.setValue(test);
            }
        });
    }

    public MutableLiveData<Test> getTest1LiveData() {
        return test1LiveData;
    }
}