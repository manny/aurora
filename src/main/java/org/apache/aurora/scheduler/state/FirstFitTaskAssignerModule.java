/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.aurora.scheduler.state;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;

import org.apache.aurora.scheduler.state.TaskAssigner.FirstFitTaskAssigner;

/**
 *  Exposes the default TaskAssigner implementation, which is a first-fit scheduling algorithm.
 */
public class FirstFitTaskAssignerModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(TaskAssigner.class).to(FirstFitTaskAssigner.class);
    bind(FirstFitTaskAssigner.class).in(Singleton.class);
  }
}
