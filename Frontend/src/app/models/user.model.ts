export class User {
    userId: string;
    name: string;
    username: string;
    password: string;

    constructor(userId: string, name: string, username: string, password: string) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}