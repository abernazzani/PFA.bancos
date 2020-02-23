import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/core/services/api/auth.service';
import { Router, RouterStateSnapshot } from '@angular/router';
import { query, style, animate, transition, trigger } from '@angular/animations';

@Component({
    selector: 'login-page',
    templateUrl: 'login-page.component.html',
})

export class LoginPageComponent implements OnInit {
    credentials = {
        username: "",
        password: "",
    };

    constructor(private authService: AuthService, private router: Router) { }



    ngOnInit() { }

    async login() {
        debugger;
        let user = await this.authService.login(this.credentials.username, this.credentials.password);
        if (user) {
            let state = this.router.routerState.snapshot
            if (state.root.queryParams["return"]) {
                let returnPage = state.root.queryParams["return"];
                this.router.navigate([`/${returnPage}`]);
            }
        }
        else {
            alert("Las credenciales son incorrectas");
        }
    }
}