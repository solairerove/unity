package com.github.vlsidlyarevich.unity.service;

import com.github.vlsidlyarevich.unity.Application;
import com.github.vlsidlyarevich.unity.dto.WorkerProfileDTO;
import com.github.vlsidlyarevich.unity.model.WorkerProfile;
import com.github.vlsidlyarevich.unity.repository.WorkerProfileRepository;
import com.github.vlsidlyarevich.unity.utils.ModelUtils;
import com.github.vlsidlyarevich.unity.utils.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;


@SpringApplicationConfiguration(Application.class)
public class WorkerProfileSearchServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SearchService workerProfileSearchService;

    @Autowired
    private WorkerProfileService workerProfileService;

    @Autowired
    private WorkerProfileRepository workerProfileRepository;

    @BeforeMethod
    public void before() {
        workerProfileRepository.deleteAll();
    }

    @AfterMethod
    public void after() {
        workerProfileRepository.deleteAll();
    }

    @Test
    public void findByFiltersTest() {
        WorkerProfileDTO workerProfile = TestUtils.generateWorkerProfileDTO();
        workerProfileService.create(workerProfile);

        HashMap<String, String> map = new HashMap<>();
        map.put("skype", workerProfile.getSkype());
        List<WorkerProfile> workerProfiles = workerProfileSearchService.find(map);
        Assert.assertEquals(ModelUtils.convertToModel(workerProfile), workerProfiles.get(0));
    }

    @Test
    public void findByFiltersExtendedTest() {
        WorkerProfileDTO workerProfile = TestUtils.generateWorkerProfileDTO();
        workerProfileService.create(workerProfile);

        HashMap<String, String> map = new HashMap<>();
        map.put("skype", workerProfile.getSkype());
        map.put("gender", workerProfile.getGender().name());
        map.put("speciality", workerProfile.getSpeciality().name());

        List<WorkerProfile> workerProfiles = workerProfileSearchService.find(map);
        Assert.assertEquals(ModelUtils.convertToModel(workerProfile), workerProfiles.get(0));
    }
}
