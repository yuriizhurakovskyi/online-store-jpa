package ua.yurii.zhurakovskyi.service.impl;

import java.util.List;

import ua.yurii.zhurakovskyi.dao.BucketDao;
import ua.yurii.zhurakovskyi.dao.impl.BucketDaoImpl;
import ua.yurii.zhurakovskyi.domain.Bucket;
import ua.yurii.zhurakovskyi.service.BucketService;

public class BucketServiceImpl implements BucketService {
	private BucketDao bucketDao;
	private static BucketService bucketServiceImpl;

	public static BucketService getBucketServiceImpl() {
		if (bucketServiceImpl == null)
			bucketServiceImpl = new BucketServiceImpl();
		return bucketServiceImpl;
	}

	private BucketServiceImpl() {
		bucketDao = new BucketDaoImpl();
	}

	@Override
	public Bucket create(Bucket bucket) {
		return bucketDao.create(bucket);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket bucket) {
		return bucketDao.update(bucket);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}
}
