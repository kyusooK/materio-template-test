<template>
    <v-app>
        <v-app-bar
                app
                clipped-left
                flat
                dark
                color="primary"
        >
            <v-app-bar-nav-icon @click="openSideBar()"></v-app-bar-nav-icon>

            <v-toolbar-title class="font-weight-bold text-uppercase">
                materiotemplate
            </v-toolbar-title>

            <v-icon class="ml-3" @click="$router.push('/')">
                mdi-home
            </v-icon>

            <v-spacer></v-spacer>

            <b style="font-size:10px;">{{username}} 님</b>

            <v-btn style="font-size:10px"
                    text
                    small
                    @click="logout()"
            >
                Logout
            </v-btn>
        </v-app-bar>

        <v-navigation-drawer
                v-model="sideBar"
                app
                clipped
                flat
        >
            <v-list>
                <v-list-group
                        v-for="menu in menus"
                        :key="menu.id"
                        no-action
                >
                    <template v-slot:activator>
                        <v-list-item-content>
                            <v-list-item-title>{{ menu.title }}</v-list-item-title>
                        </v-list-item-content>
                    </template>

                    <v-list-item
                            v-for="item in menu.items"
                            :key="item.key"
                            :to="item.url"
                            style="margin-left: -40px;"
                    >
                        <v-list-item-content>
                            <v-list-item-title>{{ item.name }}</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-group>
            </v-list>
        </v-navigation-drawer>

        <v-main>
            <router-view></router-view>
        </v-main>
    </v-app>
</template>

<script>
    export default {
        name: "App",
        data: () => ({
            username: "",
            sideBar: true,
            menus: [
                {
                    id: 'basic',
                    title: 'Basic',
                    items: [
                        {
                            key: 'companies',
                            url: '/basic/companies',
                            name: 'Company'
                        },
                        {
                            key: 'products',
                            url: '/basic/products',
                            name: 'Product'
                        },
                    ]
                },
                {
                    id: 'sales',
                    title: 'Sales',
                    items: [
                        {
                            key: 'salesOrders',
                            url: '/sales/salesOrders',
                            name: 'SalesOrder'
                        },
                    ]
                },
            ],
        }),
        created() {
            const el = document.createElement('div');
            el.setAttribute('data-app', true);
            document.body.appendChild(el);
        },
        methods: {
            openSideBar(){
                this.sideBar = !this.sideBar
            },
            logout(){
                if(confirm("로그아웃 하시겠습니까?")){
                    localStorage.clear()
                    location.href = 'http://localhost:9090/realms/master/protocol/openid-connect/logout'
                }
            },
        }
    };
</script>

<style>
</style>
