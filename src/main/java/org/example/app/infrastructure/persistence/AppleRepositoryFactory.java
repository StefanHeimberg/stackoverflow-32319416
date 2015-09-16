/*
 * Copyright 2015 Stefan Heimberg <kontakt@stefanheimberg.ch>.
 *
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
package org.example.app.infrastructure.persistence;

import org.example.app.domain.repository.AppleRepository;
import org.example.app.infrastructure.persistence.jdbc.JdbcAppleRepository;
import org.example.app.infrastructure.persistence.json.JsonAppleRepository;

/**
 *
 * @author Stefan Heimberg <kontakt@stefanheimberg.ch>
 */
public class AppleRepositoryFactory {

    private final JdbcAppleRepository jdbcAppleRepository;
    private final JsonAppleRepository jsonAppleRepository;

    public AppleRepositoryFactory(final JdbcAppleRepository jdbcAppleRepository, final JsonAppleRepository jsonAppleRepository) {
        this.jdbcAppleRepository = jdbcAppleRepository;
        this.jsonAppleRepository = jsonAppleRepository;
    }

    public AppleRepository create(final RepositoryTypeEnum repositoryTypeEnum) {
        switch (repositoryTypeEnum) {
            case JDBC:
                return jdbcAppleRepository;
            case JSON:
                return jsonAppleRepository;
            default:
                throw new RuntimeException("unknown repository type: " + repositoryTypeEnum);
        }
    }

}
