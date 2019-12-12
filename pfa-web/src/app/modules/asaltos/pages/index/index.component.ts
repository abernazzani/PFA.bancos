import { Component, OnInit } from '@angular/core';
import { Asalto } from 'src/app/core/models/asalto';
import { AsaltosService } from 'src/app/core/services/api/asaltos.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { AsaltosEditComponent } from '../edit/edit.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'asaltos-index',
    templateUrl: 'index.component.html'
})

export class AsaltoIndexComponent implements OnInit {
    asaltos: Asalto[];

    constructor(private asaltosService: AsaltosService,
        private router: Router,
        private activatedRoute: ActivatedRoute,
        private modalService: NgbModal) { }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        debugger;
        this.asaltos = await this.asaltosService.getAll();
    }

    async edit(asalto: Asalto) {
        if (asalto) {
            this.router.navigate(['edit', asalto.id], {
                relativeTo: this.activatedRoute
            });
        }
        else {
            this.router.navigate(['edit'], {
                relativeTo: this.activatedRoute
            });
        }

        // const modalRef = this.modalService.open(AsaltosEditComponent);

        // if (asalto) {
        //     modalRef.componentInstance.id = asalto.id;
        // }

        // var result = await modalRef.result;
        // debugger;
        // if (result == ModalResult.Ok) {
        //     this.getAll();
        // }
    }

    async delete(asalto: Asalto) {
        await this.asaltosService.delete(asalto.id);
        this.getAll();
    }
}