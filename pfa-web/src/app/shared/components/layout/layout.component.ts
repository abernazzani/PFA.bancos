import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/core/services/api/auth.service';

@Component({
    selector: 'app-layout',
    templateUrl: 'layout.component.html'
})

export class LayoutComponent implements OnInit {
    constructor(public authService: AuthService) { }

    ngOnInit() { }
}