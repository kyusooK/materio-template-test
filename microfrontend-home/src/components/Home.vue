<template>
    <v-container class="py-8 px-6 mt-10" fluid>
        <v-row>
            <v-card
                    v-for="(card, index) in cards"
                    :key="index"
                    class="mx-auto"
                    style="height:300px; width:300px; margin-bottom:20px;"
                    outlined
            >
                <v-list-item>
                    <v-list-item-avatar class="mx-auto" size="80" style="margin-top:80px;">
                        <v-icon color="primary" size="64">mdi-apps</v-icon>
                    </v-list-item-avatar>
                </v-list-item>
                
                <v-card-actions>
                    <v-tooltip bottom>
                        <template v-slot:activator="{ on }">
                            <v-btn
                                    v-on="on"
                                    class="mx-auto"
                                    outlined
                                    rounded
                                    :to="card.link"
                                    style="font-weight:500; font-size:20px; padding:15px; border:solid 2px; max-width:250px; overflow:hidden"
                            >
                                {{ card.text }}
                            </v-btn>
                        </template>
                        <span>{{ card.text }}</span>
                    </v-tooltip>
                </v-card-actions>
            </v-card>
        </v-row>
    </v-container>
</template>

<script>
export default {
    name: "Home",
    data: () => ({
        cards: [
            { 
                text: "Company",
                link: "/basic/companies",
            },
            { 
                text: "Product",
                link: "/basic/products",
            },
            { 
                text: "SalesOrder",
                link: "/sales/salesOrders",
            },
        ],
    }),
    methods: {
    }
}
</script>

<style>
</style>
