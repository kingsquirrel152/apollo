package io.logz.apollo.dao;

import io.logz.apollo.models.Deployment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by roiravhon on 1/5/17.
 */
public interface DeploymentDao {

    Deployment getDeployment(int id);
    List<Deployment> getAllDeployments();
    List<Deployment> getAllRunningDeployments();
    List<Deployment> getRunningAndJustFinishedDeployments();
    List<Deployment> getLatestDeployments();
    String getCurrentGitCommitSha(@Param("serviceId") int serviceId, @Param("environmentId") int environmentId);
    void addDeployment(Deployment deployment);
    void updateDeploymentStatus(@Param("id") int id, @Param("status") Deployment.DeploymentStatus status);
    void updateDeploymentEnvStatus(@Param("id") int id, @Param("envStatus") String envStatus);
    void updateDeployment(Deployment deployment);
    String getDeploymentEnvStatus(@Param("id") int id);
    List<Integer> getServicesDeployedOnEnv(@Param("environmentId") int environmentId);
}
