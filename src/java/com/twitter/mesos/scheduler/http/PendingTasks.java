package com.twitter.mesos.scheduler.http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;

import com.twitter.mesos.scheduler.async.TaskGroups;

/**
 * Servlet that exposes detailed information about tasks that are pending.
 */
@Path("/pendingtasks")
public class PendingTasks {

  private final TaskGroups taskGroups;

  @Inject
  PendingTasks(TaskGroups taskGroups) {
    this.taskGroups = Preconditions.checkNotNull(taskGroups);
  }

  /**
   * Returns information about pending tasks.
   *
   * @return HTTP response.
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getOffers() {
    return Response.ok(taskGroups.getGroups()).build();
  }
}
