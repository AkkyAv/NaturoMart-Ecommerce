import React, { useState, useEffect } from "react";
import axios from "axios";
import { Button } from "react-bootstrap";
import profileImg from '../../img/profile.jpg'
import order from '../../img/orders.jpg'
import goods from '../../img/cart.jpg'
import coupons from '../../img/coupons.jpg'
import * as Icon from "react-bootstrap-icons"
import Swal from "sweetalert2";

export const MyProductsList = () => {
    const sessionUser = JSON.parse(sessionStorage.getItem('loginFormData'));
  const token = sessionUser.token;

  const headers = {
    Authorization: `Bearer ${token}`,
  };

  const [supplier, setSupplier] = useState(null); 
  const [myProducts, setMyProducts] = useState([])

  useEffect(() => {
    axios.get(`http://localhost:8080/shop/get-supplier/${sessionUser.email}`, { headers })
      .then((response) => {
        console.log(response.data)
        setSupplier(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  useEffect(() => {
    axios.get(`http://localhost:8080/shop/all-products/supplier/${sessionUser.email}`, { headers })
      .then((response) => {
        console.log(response.data)
        setMyProducts(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const handleDeleteProduct = (productId) => {
    axios.delete(`http://localhost:8080/shop/delete-product/${productId}`, { headers })
          .then(response => {
  
              Swal.fire({
                  icon: 'success',
                  title: 'Deleted',
                  text: 'Product deleted successfully',
                  confirmButtonColor: "#127d3f",
                      confirmButtonText: "Ok",
                      preConfirm: () => {
                        return new Promise((resolve) => {
                          window.location.reload();
                          resolve()
                        });
                      },
                });
          })
          .catch(error => {
              Swal.fire({
                  icon: 'error',
                  title: 'Error',
                  text: 'Failed to delete product',
                  confirmButtonColor: "#127d3f",
                      confirmButtonText: "Ok",
                      preConfirm: () => {
                        return new Promise((resolve) => {
                          window.location.reload();
                          resolve()
                        });
                      },
                });
              console.error(error);
          });
  }

    return(
        <>
        {myProducts && (

                <div className="overflowContent2 px-5">
                {myProducts.map((products) => (
                                        <>
                                        <div key={products.productId} className="loginBox bg-light mb-4">
                                            <div className="d-flex">
                                                <div className="col-6 px-5 my-auto">
                                                    <img src={`data:image/jpeg;base64,${products.productImage}`} alt="" className="col-12 rounded-5" />
                                                    <p className="display-6 my-2">${products.price}</p>
                                                    <p className="lead">Stock available: {products.stock}</p>

                                                    <div className="d-flex justify-content-center mt-4">
                                                    <Button href={`/editProduct/${products.productId}`} variant="" className="col-6 me-1 btnBiru">Edit</Button>
                                                    <Button onClick={() => handleDeleteProduct(products.productId)} variant="" className="col-6 btn-danger">Delete</Button>
                                                    </div>
                                                
                                                </div>

                                                <div className="col-6">
                                                    <div className="loginBox">
                                                    <p className="display-6">
                                                        {products.productName}
                                                    </p>
                                                    <hr />
                                                    <div className="overflowContent px-4">
                                                    <article>{products.productDescription}</article>

                                                    </div>
                                                    </div>

                                                    

                                                </div>
                                            </div>
                                        </div>
                                        </>
                ))}
                </div>
        )}

        </>
    )
}