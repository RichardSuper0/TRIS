FROM gentoo/stage3:latest

# Sync Portage
RUN emerge-webrsync || emerge --sync

# Profilo base
RUN eselect profile set 1

# OTTIMIZZAZIONI ESTREME
RUN echo 'CFLAGS="-Ofast -pipe -march=native -mtune=native \
    -funroll-loops -fomit-frame-pointer -flto \
        -funsafe-math-optimizations -ffast-math -fno-math-errno \
            -fno-trapping-math -frename-registers -fweb \
                -fpeel-loops -ftracer -fipa-pta -fdevirtualize-at-ltrans"' \
                    >> /etc/portage/make.conf && \
                        echo 'CXXFLAGS="${CFLAGS}"' >> /etc/portage/make.conf && \
                            echo 'MAKEOPTS="-j4"' >> /etc/portage/make.conf

                            # Installo SOLO bash e fasm
                            RUN emerge --verbose \
                                app-shells/bash \
                                    dev-lang/fasm

                                    # Utente non-root
                                    RUN useradd -m dev && echo "dev ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers

                                    USER dev
                                    WORKDIR /home/dev
                                    RUN ln -s /usr/share/fasm/fasm /usr/bin/fasm