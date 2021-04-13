package leavesc.hello.network.http.repo;

import android.arch.lifecycle.MutableLiveData;

import leavesc.hello.network.http.basis.BaseRepo;
import leavesc.hello.network.http.basis.callback.RequestCallback;
import leavesc.hello.network.http.basis.callback.RequestMultiplyCallback;
import leavesc.hello.network.http.datasource.base.IFailExampleDataSource;
import leavesc.hello.network.http.datasource.base.ITestExampleDataSource;
import leavesc.hello.network.model.Test;

/**
 * 作者：leavesC
 * 时间：2019/1/30 13:06
 * 描述：
 */
public class TestExampleRepo extends BaseRepo<ITestExampleDataSource> {

    public TestExampleRepo(ITestExampleDataSource remoteDataSource) {
        super(remoteDataSource);
    }

    public MutableLiveData<Test> test(String id) {
        MutableLiveData<Test> newsPackMutableLiveData = new MutableLiveData<>();
        remoteDataSource.test(id, new RequestCallback<Test>() {
            @Override
            public void onSuccess(Test newsPack) {
                newsPackMutableLiveData.setValue(newsPack);
            }
        });
        return newsPackMutableLiveData;
    }
}