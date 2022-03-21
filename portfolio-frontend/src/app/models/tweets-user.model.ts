import { TweetsUserData } from "./tweets-user-data.model";
import { TweetsUserMeta } from "./tweets-user-meta-model";
import { TwitterUserData } from "./twitter-user-data.model";

/**
 * Author: jacoboflorez
 * Interface to receive the user's tweets.
 */
 export interface TweetsUser {

    data: TweetsUserData[];
    meta: TweetsUserMeta;
}