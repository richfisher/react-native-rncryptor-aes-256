#import "RNRncryptor.h"

@implementation RNRncryptor

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(encrypt:(NSString *)text 
                  password:(NSString *)password
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    NSData *data = [text dataUsingEncoding:NSUTF8StringEncoding];
    NSError *error;
    NSData *encryptedData = [RNEncryptor encryptData:data
                                        withSettings:kRNCryptorAES256Settings
                                            password:password
                                               error:&error];
    NSString *string = [encryptedData base64EncodedStringWithOptions:0];
    
    if(error){
        reject(@"Error", @"Decrypt failed", error);
    } else {
        resolve(string);
    }
}

RCT_EXPORT_METHOD(decrypt:(NSString *)base64 
                  password:(NSString *)password
                  resolver:(RCTPromiseResolveBlock)resolve
                  rejecter:(RCTPromiseRejectBlock)reject)
{
    NSData *data = [[NSData alloc] initWithBase64EncodedString:base64 options:0];
    NSError *error;
    NSData *decryptedData = [RNDecryptor decryptData:data
                                        withPassword:password
                                               error:&error];
    NSString *string = [[NSString alloc] initWithData:decryptedData encoding:NSUTF8StringEncoding];
    
    if(error){
        reject(@"Error", @"Decrypt failed", error);
    } else {
        resolve(string);
    }
}
@end
  
