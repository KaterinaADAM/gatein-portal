/**
 * Copyright (C) 2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.groovyscript.text;

import java.io.Writer;
import java.util.HashMap;

import org.exoplatform.resolver.ResourceResolver;

/**
 * Created by The eXo Platform SAS May 8, 2006
 */
@SuppressWarnings("serial")
public class BindingContext extends HashMap<String, Object> {

    protected ResourceResolver resolver_;

    protected Writer writer_;

    protected TemplateService service_;

    public BindingContext(ResourceResolver resolver, Writer w) {
        resolver_ = resolver;
        writer_ = w;
    }

    public ResourceResolver getResourceResolver() {
        return resolver_;
    }

    public Writer getWriter() {
        return writer_;
    }

    public void setGroovyTemplateService(TemplateService service) {
        service_ = service;
    }

    public BindingContext clone() {
        BindingContext newContext = new BindingContext(resolver_, writer_);
        newContext.putAll(this);
        newContext.setGroovyTemplateService(service_);
        return newContext;
    }

    public final void include(String name) throws Exception {
        service_.include(name, clone());
    }

}
