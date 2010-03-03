/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
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

package org.jboss.remoting3.test;

import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import org.jboss.xnio.ChannelListener;
import org.jboss.xnio.OptionMap;
import org.jboss.xnio.Options;
import org.jboss.xnio.SslTcpServer;
import org.jboss.xnio.Xnio;
import org.jboss.xnio.channels.ConnectedStreamChannel;
import org.testng.SkipException;
import org.testng.annotations.Test;

@Test(suiteName = "Remote SSL tests")
public final class RemoteSslTestCase extends AbstractRemoteTestCase {
    protected SslTcpServer getServer(final ChannelListener<ConnectedStreamChannel<InetSocketAddress>> listener, final Xnio xnio) throws NoSuchProviderException, NoSuchAlgorithmException {
        return xnio.createSslTcpServer(listener, OptionMap.builder().setSequence(Options.SSL_ENABLED_CIPHER_SUITES, "TLS_RSA_WITH_AES_128_CBC_SHA").getMap());
    }

    protected String getScheme() {
        if (true) throw new SkipException("SSL");
        return "remote+ssl";
    }
}