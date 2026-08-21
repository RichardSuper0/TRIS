FROM gentoo/stage3:latest

RUN emerge-webrsync || emerge --sync
RUN eselect profile set 1

RUN echo 'CFLAGS="-Ofast -pipe -march=native -mtune=native \
    -funroll-loops -fomit-frame-pointer -flto \
        -funsafe-math-optimizations -ffast-math -fno-math-errno \
            -fno-trapping-math -frename-registers -fweb \
                -fpeel-loops -ftracer -fipa-pta -fdevirtualize-at-ltrans"' \
                    >> /etc/portage/make.conf && \
                        echo 'CXXFLAGS="${CFLAGS}"' >> /etc/portage/make.conf && \
                            echo 'MAKEOPTS="-j8"' >> /etc/portage/make.conf

                            RUN emerge --verbose \
                                app-shells/bash \
                                    dev-lang/fasm

                                    # FIX: aggiungi fasm al PATH
                                    RUN ln -s /usr/share/fasm/fasm /usr/bin/fasm

                                    RUN useradd -m dev && echo "dev ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers

                                    USER dev
                                    WORKDIR /home/dev