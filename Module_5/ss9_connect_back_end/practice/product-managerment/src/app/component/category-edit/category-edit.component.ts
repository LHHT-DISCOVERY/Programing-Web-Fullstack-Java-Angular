// import { ToastrService } from 'ngx-toastr';
// import { Component, OnInit } from '@angular/core';
// import { FormControl, FormGroup } from '@angular/forms';
// import { ActivatedRoute, ParamMap, Router } from '@angular/router';
// import { CategoryService } from 'src/app/service/category-service/category.service';


// @Component({
//   selector: 'app-category-edit',
//   templateUrl: './category-edit.component.html',
//   styleUrls: ['./category-edit.component.css']
// })
// export class CategoryEditComponent implements OnInit {

//   categoryForm: FormGroup;
//   id: number;

//   constructor(private categoryService: CategoryService,
//               private activatedRoute: ActivatedRoute,
//               private router: Router ,
//               private toast : ToastrService) {
//     this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
//       this.id = +paramMap.get('id');
//       this.getCategory(this.id);
//     });
//   }

//   ngOnInit(): void {
//   }

//   getCategory(id: number) {
//     return this.categoryService.findById(id).subscribe(category => {
//       this.categoryForm = new FormGroup({
//         name: new FormControl(category.name)
//       });
//     });
//   }

//   updateCategory(id: number) {
//     const category = this.categoryForm.value;
//     this.categoryService.updateCategory(id, category).subscribe(() => {
//       this.router.navigate(['/categoryList']);
//       this.toast.success("Cập nhật thành công")
//     }, error => {
//       console.log(error);
//     });
//   }
// }
